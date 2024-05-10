-- 注意：该页面对应的前台目录为views/nl_questionnaire_list文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024042102031170570', NULL, '测评问卷生成', '/nl_questionnaire_list/nlQuestionnaireListList', 'nl_questionnaire_management/nl_questionnaire_list/NlQuestionnaireListList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-04-21 14:03:57', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042102031170571', '2024042102031170570', '添加测评问卷生成', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_list:nl_questionnaire_list:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-21 14:03:57', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042102031170572', '2024042102031170570', '编辑测评问卷生成', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_list:nl_questionnaire_list:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-21 14:03:57', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042102031170573', '2024042102031170570', '删除测评问卷生成', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_list:nl_questionnaire_list:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-21 14:03:57', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042102031170574', '2024042102031170570', '批量删除测评问卷生成', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_list:nl_questionnaire_list:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-21 14:03:57', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042102031170575', '2024042102031170570', '导出excel_测评问卷生成', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_list:nl_questionnaire_list:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-21 14:03:57', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042102031170576', '2024042102031170570', '导入excel_测评问卷生成', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_list:nl_questionnaire_list:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-21 14:03:57', NULL, NULL, 0, 0, '1', 0);