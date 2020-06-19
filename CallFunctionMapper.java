package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CallFunctionMapper {

	@Select(" call get_bal(" +
			"{#{s.res, mode=OUT, jdbcType=INTEGER} ="+
			"    #{s.num1, mode=IN, jdbcType=INTEGER}" +
			"    ,#{s.num2, mode=IN, jdbcType=INTEGER}" +
			"  )}")
	@Options(statementType = StatementType.CALLABLE)
	public void createNo(@Param(value = "s")CallFunction s);


	@Select(" select get_bal(" +
			"    #{p.num1, mode=IN, jdbcType=CHAR}" +
			"    ,#{p.num2, mode=IN, jdbcType=CHAR}" +
			"  ) from dual")
	public Integer createNo1(@Param(value = "p") CallFunction p);

}
