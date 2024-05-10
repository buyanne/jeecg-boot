<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <a-form-model ref="form" :model="model" :rules="validatorRules" slot="detail">
        <a-row>
          <a-col :span="24">
            <a-form-model-item label="用户id" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="employeeId">
              <a-input-number v-model="model.employeeId" placeholder="请输入用户id" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="测评计划id" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="planId">
              <a-input-number v-model="model.planId" placeholder="请输入测评计划id" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="问卷id" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="questionnaireId">
              <a-input-number v-model="model.questionnaireId" placeholder="请输入问卷id" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="问卷得分" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="questionScore">
              <a-input-number v-model="model.questionScore" placeholder="请输入问卷得分" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="提交时间" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="submitTime">
              <j-date placeholder="请选择提交时间"  v-model="model.submitTime" :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" style="width: 100%" />
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
    name: 'NlEmployeePyschologySingleScoreForm',
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
           employeeId: [
              { required: true, message: '请输入用户id!'},
           ],
           questionnaireId: [
              { required: true, message: '请输入问卷id!'},
           ],
           submitTime: [
              { required: true, message: '请输入提交时间!'},
           ],
        },
        url: {
          add: "/nl_pyschology_score/nlEmployeePyschologySingleScore/add",
          edit: "/nl_pyschology_score/nlEmployeePyschologySingleScore/edit",
          queryById: "/nl_pyschology_score/nlEmployeePyschologySingleScore/queryById"
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