-- 注意：该页面对应的前台目录为views/nl_politics_reply文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024050804211860010', NULL, '思想状态回答表', '/nl_politics_reply/nlEmployeePoliticsRequestReplyList', 'nl_employee_assess_management/ability_total/politics_reply/NlEmployeePoliticsRequestReplyList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-08 16:21:01', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024050804211860011', '2024050804211860010', '添加思想状态回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_politics_reply:nl_employee_politics_request_reply:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-08 16:21:01', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024050804211860012', '2024050804211860010', '编辑思想状态回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_politics_reply:nl_employee_politics_request_reply:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-08 16:21:01', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024050804211860013', '2024050804211860010', '删除思想状态回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_politics_reply:nl_employee_politics_request_reply:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-08 16:21:01', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024050804211860014', '2024050804211860010', '批量删除思想状态回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_politics_reply:nl_employee_politics_request_reply:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-08 16:21:01', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024050804211860015', '2024050804211860010', '导出excel_思想状态回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_politics_reply:nl_employee_politics_request_reply:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-08 16:21:01', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024050804211870016', '2024050804211860010', '导入excel_思想状态回答表', NULL, NULL, 0, NULL, NULL, 2, 'nl_politics_reply:nl_employee_politics_request_reply:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-08 16:21:01', NULL, NULL, 0, 0, '1', 0);