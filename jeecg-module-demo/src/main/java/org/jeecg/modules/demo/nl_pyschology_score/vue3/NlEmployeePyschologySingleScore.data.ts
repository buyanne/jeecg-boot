import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '用户id',
    align:"center",
    dataIndex: 'employeeId'
   },
   {
    title: '测评计划id',
    align:"center",
    dataIndex: 'planId'
   },
   {
    title: '问卷id',
    align:"center",
    dataIndex: 'questionnaireId'
   },
   {
    title: '问卷得分',
    align:"center",
    dataIndex: 'questionScore'
   },
   {
    title: '提交时间',
    align:"center",
    dataIndex: 'submitTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '用户id',
    field: 'employeeId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入用户id!'},
          ];
     },
  },
  {
    label: '测评计划id',
    field: 'planId',
    component: 'InputNumber',
  },
  {
    label: '问卷id',
    field: 'questionnaireId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入问卷id!'},
          ];
     },
  },
  {
    label: '问卷得分',
    field: 'questionScore',
    component: 'InputNumber',
  },
  {
    label: '提交时间',
    field: 'submitTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入提交时间!'},
          ];
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  employeeId: {title: '用户id',order: 0,view: 'number', type: 'number',},
  planId: {title: '测评计划id',order: 1,view: 'number', type: 'number',},
  questionnaireId: {title: '问卷id',order: 2,view: 'number', type: 'number',},
  questionScore: {title: '问卷得分',order: 3,view: 'number', type: 'number',},
  submitTime: {title: '提交时间',order: 4,view: 'datetime', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}