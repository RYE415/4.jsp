package anno5;

import org.springframework.stereotype.Component;

/*
 * 빈즈에 관련된 클래스가 30개 이상
 * 
 * <bean id="camera" class="anno5.Camera" /> =>수동 등록
 * 
 * @Component=>클래스와 관련된 어노테이션
 * 스프링 컨테이너가 어느 특정 패키지를 지정->자동적으로 그 패키지에 들어가 있는
 * 									모든 클래스 중에서 @Component가 붙어있는 클래스를 빈즈로 등록(자동)
 */
@Component
public class Camera{} //기본생성자 자동 생성->호출
