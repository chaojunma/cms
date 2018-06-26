#sql("findByName")
	SELECT * 
		FROM user_info
	WHERE user_name = ?
		AND password = ?
#end