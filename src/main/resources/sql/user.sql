#namespace("user")

	#sql("findByName")
		SELECT * 
			FROM user_info
		WHERE email = ?
			AND password = ?
			AND is_lock = 0
	#end
	
	
	#sql("findByPage")
		SELECT *
			FROM user_info
		WHERE 1=1
		#if(key??)
			AND (
					user_name LIKE concat('%',#para(key),'%')
					OR 
					email LIKE concat('%',#para(key),'%')
					OR
					phone LIKE concat('%',#para(key),'%')
				)
		#end
		#if(createTime??)
			AND create_time>=#para(createTime)
		#end
		#if(isLock??)
			AND is_lock=#para(isLock)
		#end
			ORDER BY id #(order)
	#end
	
#end