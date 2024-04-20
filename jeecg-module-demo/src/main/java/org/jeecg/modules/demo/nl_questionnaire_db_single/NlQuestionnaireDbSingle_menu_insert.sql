-- 注意：该页面对应的前台目录为views/nl_questionnaire_db_single文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024042010563710250', NULL, '问卷题库管理', '/nl_questionnaire_db_single/nlQuestionnaireDbSingleList', 'nl_questionnaire_management/nl_questionnaire_db_single/NlQuestionnaireDbSingleList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-04-20 10:56:25', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042010563710251', '2024042010563710250', '添加问卷题库管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_db_single:nl_questionnaire_db_single:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-20 10:56:25', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042010563710252', '2024042010563710250', '编辑问卷题库管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_db_single:nl_questionnaire_db_single:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-20 10:56:25', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042010563710253', '2024042010563710250', '删除问卷题库管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_db_single:nl_questionnaire_db_single:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-20 10:56:25', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042010563710254', '2024042010563710250', '批量删除问卷题库管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_db_single:nl_questionnaire_db_single:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-20 10:56:25', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042010563710255', '2024042010563710250', '导出excel_问卷题库管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_db_single:nl_questionnaire_db_single:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-20 10:56:25', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024042010563720256', '2024042010563710250', '导入excel_问卷题库管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_db_single:nl_questionnaire_db_single:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-20 10:56:25', NULL, NULL, 0, 0, '1', 0);