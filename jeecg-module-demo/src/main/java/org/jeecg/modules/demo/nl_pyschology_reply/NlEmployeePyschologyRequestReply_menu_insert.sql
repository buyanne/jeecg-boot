-- 注意：该页面对应的前台目录为views/nl_pyschology_reply文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024051008096840390', NULL, '心理状况回答表', '/nl_pyschology_reply/nlEmployeePyschologyRequestReplyList', 'nl_employee_assess_management/ability_total/nl_pyschology_reply/NlEmployeePyschologyRequestReplyList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-10 20:09:39', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008096840391', '2024051008096840390', '添加心理状况回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_reply:nl_employee_pyschology_request_reply:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:09:39', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008096840392', '2024051008096840390', '编辑心理状况回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_reply:nl_employee_pyschology_request_reply:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:09:39', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008096840393', '2024051008096840390', '删除心理状况回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_reply:nl_employee_pyschology_request_reply:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:09:39', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008096840394', '2024051008096840390', '批量删除心理状况回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_reply:nl_employee_pyschology_request_reply:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:09:39', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008096840395', '2024051008096840390', '导出excel_心理状况回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_reply:nl_employee_pyschology_request_reply:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:09:39', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051008096840396', '2024051008096840390', '导入excel_心理状况回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_pyschology_reply:nl_employee_pyschology_request_reply:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-10 20:09:39', NULL, NULL, 0, 0, '1', 0);