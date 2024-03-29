-- 注意：该页面对应的前台目录为views/nl_evaluation_questionnaire_management.nl_questionnaire_index文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024032707467250070', NULL, '问卷指标管理', '/nl_evaluation_questionnaire_management.nl_questionnaire_index/nlQuestionnaireIndexList', 'nl_evaluation_questionnaire_management.nl_questionnaire_index/NlQuestionnaireIndexList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-03-27 19:46:07', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032707467250071', '2024032707467250070', '添加问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 19:46:07', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032707467250072', '2024032707467250070', '编辑问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 19:46:07', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032707467250073', '2024032707467250070', '删除问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 19:46:07', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032707467250074', '2024032707467250070', '批量删除问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 19:46:07', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032707467250075', '2024032707467250070', '导出excel_问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 19:46:07', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032707467250076', '2024032707467250070', '导入excel_问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 19:46:07', NULL, NULL, 0, 0, '1', 0);