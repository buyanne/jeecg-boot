-- 注意：该页面对应的前台目录为views/nl_employee_review文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202402041204870030', NULL, '适岗能力初评', '/nl_employee_review/nlEmployeeReviewList', 'nl_employee_assess_management/nl_employee_review/NlEmployeeReviewList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-02-04 00:04:03', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202402041204870031', '202402041204870030', '添加适岗能力初评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_review:nl_employee_review:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-04 00:04:03', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202402041204880032', '202402041204870030', '编辑适岗能力初评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_review:nl_employee_review:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-04 00:04:03', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202402041204880033', '202402041204870030', '删除适岗能力初评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_review:nl_employee_review:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-04 00:04:03', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202402041204880034', '202402041204870030', '批量删除适岗能力初评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_review:nl_employee_review:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-04 00:04:03', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202402041204880035', '202402041204870030', '导出excel_适岗能力初评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_review:nl_employee_review:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-04 00:04:03', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202402041204880036', '202402041204870030', '导入excel_适岗能力初评', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_review:nl_employee_review:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-04 00:04:03', NULL, NULL, 0, 0, '1', 0);