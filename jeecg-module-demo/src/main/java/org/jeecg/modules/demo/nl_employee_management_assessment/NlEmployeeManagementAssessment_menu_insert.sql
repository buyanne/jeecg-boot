-- 注意：该页面对应的前台目录为views/nl_employee_management_assessment文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024051102538750040', NULL, '管理沟通能力', '/nl_employee_management_assessment/nlEmployeeManagementAssessmentList', 'nl_employee_assess_management/ability_total/nl_employee_management_assessment/NlEmployeeManagementAssessmentList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-11 02:53:04', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051102538750041', '2024051102538750040', '添加管理沟通能力', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_management_assessment:nl_employee_management_assessment:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 02:53:04', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051102538750042', '2024051102538750040', '编辑管理沟通能力', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_management_assessment:nl_employee_management_assessment:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 02:53:04', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051102538750043', '2024051102538750040', '删除管理沟通能力', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_management_assessment:nl_employee_management_assessment:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 02:53:04', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051102538750044', '2024051102538750040', '批量删除管理沟通能力', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_management_assessment:nl_employee_management_assessment:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 02:53:04', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051102538750045', '2024051102538750040', '导出excel_管理沟通能力', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_management_assessment:nl_employee_management_assessment:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 02:53:04', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051102538750046', '2024051102538750040', '导入excel_管理沟通能力', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_management_assessment:nl_employee_management_assessment:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 02:53:04', NULL, NULL, 0, 0, '1', 0);