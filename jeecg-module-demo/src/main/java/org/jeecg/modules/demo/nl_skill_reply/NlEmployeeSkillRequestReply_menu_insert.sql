-- 注意：该页面对应的前台目录为views/nl_skill_reply文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024051112187040130', NULL, '技能测评', '/nl_skill_reply/nlEmployeeSkillRequestReplyList', 'nl_employee_assess_management/ability_total/nl_skill_reply/NlEmployeeSkillRequestReplyList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-05-11 12:18:13', NULL, NULL, 0);

-- 权限控制sql
-- 新增

INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112187040131', '2024051112187040130', '添加技能测评', NULL, NULL, 0, NULL, NULL, 2, 'nl_skill_reply:nl_employee_skill_request_reply:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 12:18:13', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112187040132', '2024051112187040130', '编辑技能测评', NULL, NULL, 0, NULL, NULL, 2, 'nl_skill_reply:nl_employee_skill_request_reply:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 12:18:13', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112187040133', '2024051112187040130', '删除技能测评', NULL, NULL, 0, NULL, NULL, 2, 'nl_skill_reply:nl_employee_skill_request_reply:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 12:18:13', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112187040134', '2024051112187040130', '批量删除技能测评', NULL, NULL, 0, NULL, NULL, 2, 'nl_skill_reply:nl_employee_skill_request_reply:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 12:18:13', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112187040135', '2024051112187040130', '导出excel_技能测评', NULL, NULL, 0, NULL, NULL, 2, 'nl_skill_reply:nl_employee_skill_request_reply:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 12:18:13', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024051112187040136', '2024051112187040130', '导入excel_技能测评', NULL, NULL, 0, NULL, NULL, 2, 'nl_skill_reply:nl_employee_skill_request_reply:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-05-11 12:18:13', NULL, NULL, 0, 0, '1', 0);