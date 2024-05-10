-- 注意：该页面对应的前台目录为views/physiology_info文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024051112442890270', NULL, '生理状况测评', '/physiology_info/nlEmployeePhysiologyInfoList', 'nl_employee_assess_management/ability_total/physiology_info/NlEmployeePhysiologyInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-11 00:44:27', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112442890271', '2024051112442890270', '添加生理状况测评', NULL, NULL, 0, NULL, NULL, 2, 'physiology_info:nl_employee_physiology_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 00:44:27', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112442890272', '2024051112442890270', '编辑生理状况测评', NULL, NULL, 0, NULL, NULL, 2, 'physiology_info:nl_employee_physiology_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 00:44:27', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112442890273', '2024051112442890270', '删除生理状况测评', NULL, NULL, 0, NULL, NULL, 2, 'physiology_info:nl_employee_physiology_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 00:44:27', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112442890274', '2024051112442890270', '批量删除生理状况测评', NULL, NULL, 0, NULL, NULL, 2, 'physiology_info:nl_employee_physiology_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 00:44:27', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112442890275', '2024051112442890270', '导出excel_生理状况测评', NULL, NULL, 0, NULL, NULL, 2, 'physiology_info:nl_employee_physiology_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 00:44:27', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112442890276', '2024051112442890270', '导入excel_生理状况测评', NULL, NULL, 0, NULL, NULL, 2, 'physiology_info:nl_employee_physiology_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 00:44:27', NULL, NULL, 0, 0, '1', 0);