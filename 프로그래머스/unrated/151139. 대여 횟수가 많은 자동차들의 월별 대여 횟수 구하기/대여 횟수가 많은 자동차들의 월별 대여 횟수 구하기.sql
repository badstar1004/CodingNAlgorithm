-- 코드를 입력하세요
    -- 임시테이블 생성 (8월 ~ 10월 5회 이상 대여한 자동차ID)
    WITH CAR_RENTAL AS
    (
      SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
       WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
      HAVING COUNT(*) >= 5
    )
    
     # SELECT * FROM CAR_RENTAL ORDER BY MONTH, CAR_ID DESC;
    
    -- 조회
    SELECT MONTH(START_DATE)    MONTH
         , CAR_ID               CAR_ID
         , COUNT(*)             RECORDS
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
     WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
       AND CAR_ID IN (SELECT CAR_ID
                        FROM CAR_RENTAL)
  GROUP BY MONTH
         , CAR_ID
  ORDER BY MONTH
         , CAR_ID DESC

