-- 注意：该页面对应的前台目录为views/nl_employee_assess_management/nl_employee_interview_info文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024032712093010010', NULL, '专家面试预约', '/nl_employee_assess_management/nl_employee_interview_info/nlEmployeeIntviewInfoList', 'nl_employee_assess_management/nl_employee_interview_info/NlEmployeeIntviewInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-03-27 12:09:01', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032712093010011', '2024032712093010010', '添加专家面试预约', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 12:09:01', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032712093010012', '2024032712093010010', '编辑专家面试预约', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 12:09:01', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032712093010013', '2024032712093010010', '删除专家面试预约', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 12:09:01', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032712093010014', '2024032712093010010', '批量删除专家面试预约', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 12:09:01', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032712093010015', '2024032712093010010', '导出excel_专家面试预约', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 12:09:01', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024032712093010016', '2024032712093010010', '导入excel_专家面试预约', NULL, NULL, 0, NULL, NULL, 2, 'nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-03-27 12:09:01', NULL, NULL, 0, 0, '1', 0);