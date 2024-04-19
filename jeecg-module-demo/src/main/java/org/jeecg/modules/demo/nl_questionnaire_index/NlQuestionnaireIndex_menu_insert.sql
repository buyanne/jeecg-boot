-- 注意：该页面对应的前台目录为views/nl_questionnaire_index文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024041911388920500', NULL, '问卷指标管理', '/nl_questionnaire_index/nlQuestionnaireIndexList', 'nl_questionnaire_management/nl_questionnaire_index/NlQuestionnaireIndexList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-04-19 11:38:50', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024041911388920501', '2024041911388920500', '添加问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_index:nl_questionnaire_index:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-19 11:38:50', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024041911388920502', '2024041911388920500', '编辑问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_index:nl_questionnaire_index:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-19 11:38:50', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024041911388920503', '2024041911388920500', '删除问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_index:nl_questionnaire_index:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-19 11:38:50', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024041911388920504', '2024041911388920500', '批量删除问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_index:nl_questionnaire_index:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-19 11:38:50', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024041911388920505', '2024041911388920500', '导出excel_问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_index:nl_questionnaire_index:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-19 11:38:50', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024041911388920506', '2024041911388920500', '导入excel_问卷指标管理', NULL, NULL, 0, NULL, NULL, 2, 'nl_questionnaire_index:nl_questionnaire_index:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-04-19 11:38:50', NULL, NULL, 0, 0, '1', 0);