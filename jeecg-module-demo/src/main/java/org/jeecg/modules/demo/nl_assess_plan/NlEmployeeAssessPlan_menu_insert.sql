-- 注意：该页面对应的前台目录为views/nl_assess_plan文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024013102349550500', NULL, '测评计划管理', '/nl_assess_plan/nlEmployeeAssessPlanList', 'nl_employee_assess_management/nl_assess_plan/NlEmployeeAssessPlanList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-01-31 14:34:50', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024013102349560501', '2024013102349550500', '添加测评计划管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_assess_plan:nl_employee_assess_plan:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-31 14:34:50', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024013102349560502', '2024013102349550500', '编辑测评计划管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_assess_plan:nl_employee_assess_plan:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-31 14:34:50', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024013102349560503', '2024013102349550500', '删除测评计划管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_assess_plan:nl_employee_assess_plan:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-31 14:34:50', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024013102349560504', '2024013102349550500', '批量删除测评计划管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_assess_plan:nl_employee_assess_plan:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-31 14:34:50', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024013102349560505', '2024013102349550500', '导出excel_测评计划管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_assess_plan:nl_employee_assess_plan:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-31 14:34:50', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024013102349560506', '2024013102349550500', '导入excel_测评计划管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_assess_plan:nl_employee_assess_plan:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-31 14:34:50', NULL, NULL, 0, 0, '1', 0);