-- 注意：该页面对应的前台目录为views/specialist文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024012911294210230', NULL, 'nl_specialist_info', '/specialist/nlSpecialistInfoList', 'system/specialist/NlSpecialistInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-01-29 23:29:23', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024012911294210231', '2024012911294210230', '添加nl_specialist_info', NULL, NULL, 0, NULL, NULL, 2, 'specialist:nl_specialist_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-29 23:29:23', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024012911294210232', '2024012911294210230', '编辑nl_specialist_info', NULL, NULL, 0, NULL, NULL, 2, 'specialist:nl_specialist_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-29 23:29:23', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024012911294210233', '2024012911294210230', '删除nl_specialist_info', NULL, NULL, 0, NULL, NULL, 2, 'specialist:nl_specialist_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-29 23:29:23', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024012911294210234', '2024012911294210230', '批量删除nl_specialist_info', NULL, NULL, 0, NULL, NULL, 2, 'specialist:nl_specialist_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-29 23:29:23', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024012911294210235', '2024012911294210230', '导出excel_nl_specialist_info', NULL, NULL, 0, NULL, NULL, 2, 'specialist:nl_specialist_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-29 23:29:23', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024012911294210236', '2024012911294210230', '导入excel_nl_specialist_info', NULL, NULL, 0, NULL, NULL, 2, 'specialist:nl_specialist_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-29 23:29:23', NULL, NULL, 0, 0, '1', 0);
