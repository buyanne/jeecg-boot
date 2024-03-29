<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <a-form-model ref="form" :model="model" :rules="validatorRules" slot="detail">
        <a-row>
          <a-col :span="24">
            <a-form-model-item label="上级节点" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="parentId">
              <a-input-number v-model="model.parentId" placeholder="请输入上级节点" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="指标名称" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="indexName">
              <a-input v-model="model.indexName" placeholder="请输入指标名称"  ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="指标权重" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="indexWeight">
              <a-input-number v-model="model.indexWeight" placeholder="请输入指标权重" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="指标顺序" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="order">
              <a-input-number v-model="model.order" placeholder="请输入指标顺序" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="适用阶段" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="stageType">
              <a-input-number v-model="model.stageType" placeholder="请输入适用阶段" style="width: 100%" />
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
    </j-form-container>
  </a-spin>
</template>

<script>

  import { httpAction, getAction } from '@/api/manage'
  import { validateDuplicateValue } from '@/utils/util'

  export default {
    name: 'NlQuestionnaireIndexForm',
    components: {
    },
    props: {
      //表单禁用
      disabled: {
        type: Boolean,
        default: false,
        required: false
      }
    },
    data () {
      return {
        model:{
         },
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        validatorRules: {
           parentId: [
              { required: true, message: '请输入上级节点!'},
           ],
           indexName: [
              { required: true, message: '请输入指标名称!'},
           ],
           indexWeight: [
              { required: true, message: '请输入指标权重!'},
           ],
           order: [
              { required: true, message: '请输入指标顺序!'},
           ],
           stageType: [
              { required: true, message: '请输入适用阶段!'},
           ],
        },
        url: {
          add: "/nl_evaluation_questionnaire_management.nl_questionnaire_index/nlQuestionnaireIndex/add",
          edit: "/nl_evaluation_questionnaire_management.nl_questionnaire_index/nlQuestionnaireIndex/edit",
          queryById: "/nl_evaluation_questionnaire_management.nl_questionnaire_index/nlQuestionnaireIndex/queryById"
        }
      }
    },
    computed: {
      formDisabled(){
        return this.disabled
      },
    },
    created () {
       //备份model原始值
      this.modelDefault = JSON.parse(JSON.stringify(this.model));
    },
    methods: {
      add () {
        this.edit(this.modelDefault);
      },
      edit (record) {
        this.model = Object.assign({}, record);
        this.visible = true;
      },
      submitForm () {
        const that = this;
        // 触发表单验证
        this.$refs.form.validate(valid => {
          if (valid) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            httpAction(httpurl,this.model,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
            })
          }
         
        })
      },
    }
  }
</script>