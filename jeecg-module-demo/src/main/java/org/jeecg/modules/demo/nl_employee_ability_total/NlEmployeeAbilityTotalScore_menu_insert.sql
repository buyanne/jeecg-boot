-- 注意：该页面对应的前台目录为views/nl_employee_ability_total文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024051105184060520', NULL, '适岗能力终评', '/nl_employee_ability_total/nlEmployeeAbilityTotalScoreList', 'nl_employee_assess_management/ability_total/nl_employee_ability_total/NlEmployeeAbilityTotalScoreList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-11 17:18:52', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051105184070521', '2024051105184060520', '添加适岗能力终评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_ability_total:nl_employee_ability_total_score:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 17:18:52', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051105184070522', '2024051105184060520', '编辑适岗能力终评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_ability_total:nl_employee_ability_total_score:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 17:18:52', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051105184070523', '2024051105184060520', '删除适岗能力终评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_ability_total:nl_employee_ability_total_score:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 17:18:52', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051105184070524', '2024051105184060520', '批量删除适岗能力终评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_ability_total:nl_employee_ability_total_score:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 17:18:52', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051105184070525', '2024051105184060520', '导出excel_适岗能力终评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_ability_total:nl_employee_ability_total_score:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 17:18:52', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051105184070526', '2024051105184060520', '导入excel_适岗能力终评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_ability_total:nl_employee_ability_total_score:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 17:18:52', NULL, NULL, 0, 0, '1', 0);