package com.example.couponcore.configuration;
// QueryDSL  설정 정의 -> 빌드하면 > 빌드
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class QueryDslConfiguration {

  @PersistenceContext
  private final EntityManager entityManager; // 엔티티 매니저 주입

  @Bean
  public JPAQueryFactory jpaQueryFactory() {
    return new JPAQueryFactory(entityManager); // JPAQueryFactory 빈 등록
  }
}
