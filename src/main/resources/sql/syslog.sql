#namespace("log")

	#sql("findByPage")
		SELECT l.*, u.user_name
			FROM sys_log l
		LEFT JOIN user_info u ON l.user_id = u.id
			WHERE 1=1
		#if(key??)
			AND (
					u.user_name LIKE concat('%',#para(key),'%')
					OR
					l.url LIKE concat('%',#para(key),'%')
				)
		#end
		#if(createTime??)
			AND l.create_time>=#para(createTime)
		#end
		#if(level??)
			AND l.level=#para(level)
		#end
			ORDER BY l.id #(order)
	#end
	
#end