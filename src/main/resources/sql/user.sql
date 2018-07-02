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
		#if(userName??)
			AND user_name LIKE concat('%',#para(userName),'%')
		#end
			ORDER BY id #(orderStr)
	#end
	
#end