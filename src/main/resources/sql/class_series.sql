#namespace("series")

	#sql("findByPage")
		SELECT *
			FROM class_series
		WHERE 1=1
		#if(key??)
			AND (
					title LIKE concat('%',#para(key),'%')
					OR
					description LIKE concat('%',#para(key),'%')
					OR
					instructor LIKE concat('%',#para(key),'%')
				)
		#end
		#if(createTime??)
			AND create_time>=#para(createTime)
		#end
			ORDER BY id #(order)
	#end
	
#end