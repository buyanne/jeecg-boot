-- 注意：该页面对应的前台目录为views/perception_assessment_main文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024051011589960520', NULL, '综合感知测评主表', '/perception_assessment_main/nlEmployeePerceptionAssessmentMainList', 'nl_employee_assess_management/ability_total/perception_assessment_main/perception_assessment_main/NlEmployeePerceptionAssessmentMainList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-10 23:58:52', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051011589960521', '2024051011589960520', '添加综合感知测评主表', NULL, NULL, 0, NULL, NULL, 2, 'perception_assessment_main:nl_employee_perception_assessment_main:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 23:58:52', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051011589960522', '2024051011589960520', '编辑综合感知测评主表', NULL, NULL, 0, NULL, NULL, 2, 'perception_assessment_main:nl_employee_perception_assessment_main:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 23:58:52', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051011589960523', '2024051011589960520', '删除综合感知测评主表', NULL, NULL, 0, NULL, NULL, 2, 'perception_assessment_main:nl_employee_perception_assessment_main:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 23:58:52', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051011589960524', '2024051011589960520', '批量删除综合感知测评主表', NULL, NULL, 0, NULL, NULL, 2, 'perception_assessment_main:nl_employee_perception_assessment_main:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 23:58:52', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051011589960525', '2024051011589960520', '导出excel_综合感知测评主表', NULL, NULL, 0, NULL, NULL, 2, 'perception_assessment_main:nl_employee_perception_assessment_main:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 23:58:52', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051011589960526', '2024051011589960520', '导入excel_综合感知测评主表', NULL, NULL, 0, NULL, NULL, 2, 'perception_assessment_main:nl_employee_perception_assessment_main:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 23:58:52', NULL, NULL, 0, 0, '1', 0);