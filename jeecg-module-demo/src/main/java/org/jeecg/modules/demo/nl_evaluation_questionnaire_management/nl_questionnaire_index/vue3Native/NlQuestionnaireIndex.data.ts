import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '上级节点',
    align: "center",
    dataIndex: 'parentId'
  },
  {
    title: '指标名称',
    align: "center",
    dataIndex: 'indexName'
  },
  {
    title: '指标权重',
    align: "center",
    dataIndex: 'indexWeight'
  },
  {
    title: '指标顺序',
    align: "center",
    dataIndex: 'order'
  },
  {
    title: '适用阶段',
    align: "center",
    dataIndex: 'stageType'
  },
];

//查询数据
export const searchFormSchema: FormSchema[] = [
];

//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '上级节点',
    field: 'parentId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入上级节点!'},
             ];
    },
  },
  {
    label: '指标名称',
    field: 'indexName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入指标名称!'},
             ];
    },
  },
  {
    label: '指标权重',
    field: 'indexWeight',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入指标权重!'},
             ];
    },
  },
  {
    label: '指标顺序',
    field: 'order',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入指标顺序!'},
             ];
    },
  },
  {
    label: '适用阶段',
    field: 'stageType',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入适用阶段!'},
             ];
    },
  },
	// TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];

// 高级查询数据
export const superQuerySchema = {
  parentId: {title: '上级节点',order: 0,view: 'number', type: 'number',},
  indexName: {title: '指标名称',order: 1,view: 'text', type: 'string',},
  indexWeight: {title: '指标权重',order: 2,view: 'number', type: 'number',},
  order: {title: '指标顺序',order: 3,view: 'number', type: 'number',},
  stageType: {title: '适用阶段',order: 4,view: 'number', type: 'number',},
};
