package com.gura.spring05.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gura.spring05.Exception.NotAllowException;
import com.gura.spring05.file.dao.FileDao;
import com.gura.spring05.file.dto.FileDto;

@Aspect
@Component
public class FileAspect {
	@Autowired
	private FileDao dao;
	/*
	 * com.gura.spring05.file.service 패키지에 있는
	 * 모든 클래스 중에 delete로 시작하는 모든 메소드에 적용할 aspect
	 */
	@Around("execution(void com.gura.spring05.file.service.*.delete*(..)))")
	public void ckeckedDelete(ProceedingJoinPoint joinPoint) throws Throwable {
		int num=0;
		HttpServletRequest request=null;
		
		Object[] args=joinPoint.getArgs();
		for(Object tmp:args) {
			if(tmp instanceof Integer) {
				num=(Integer)tmp;
			} else if(tmp instanceof HttpServletRequest) {
				request=(HttpServletRequest)tmp;
			}
		}
		FileDto dto=dao.getData(num);
		String id=(String)request.getSession().getAttribute("id");
		// 만일 로그인된 아이디와 글 작성자가 다르면 에러를 응답한다.
		if(!dto.getWriter().equals(id)){
			throw new NotAllowException("남의 파일을 삭제할 수 없습니다.");
		}
		joinPoint.proceed();
	}
}
