#namespace("classify")

	#sql("findByPage")
		SELECT *
			FROM classify
		WHERE 1=1
		#if(name??)
			AND name LIKE concat('%',#para(name),'%')
		#end
		#if(createTime??)
			AND create_time>=#para(createTime)
		#end
			ORDER BY id #(order)
	#end
	
#end