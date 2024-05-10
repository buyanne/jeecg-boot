-- 注意：该页面对应的前台目录为views/nl_pyschology_score文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024051008109500020', NULL, 'nl_employee_pyschology_single_score', '/nl_pyschology_score/nlEmployeePyschologySingleScoreList', 'nl_pyschology_score/NlEmployeePyschologySingleScoreList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-10 20:10:02', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008109500021', '2024051008109500020', '添加nl_employee_pyschology_single_score', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_score:nl_employee_pyschology_single_score:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:10:02', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008109500022', '2024051008109500020', '编辑nl_employee_pyschology_single_score', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_score:nl_employee_pyschology_single_score:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:10:02', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008109500023', '2024051008109500020', '删除nl_employee_pyschology_single_score', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_score:nl_employee_pyschology_single_score:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:10:02', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008109500024', '2024051008109500020', '批量删除nl_employee_pyschology_single_score', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_score:nl_employee_pyschology_single_score:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:10:02', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008109500025', '2024051008109500020', '导出excel_nl_employee_pyschology_single_score', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_score:nl_employee_pyschology_single_score:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:10:02', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008109500026', '2024051008109500020', '导入excel_nl_employee_pyschology_single_score', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_score:nl_employee_pyschology_single_score:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:10:02', NULL, NULL, 0, 0, '1', 0);