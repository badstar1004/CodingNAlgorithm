-- 코드를 입력하세요
    -- 21년에 가입한 전체 회원수
    SET @TOTLA_CNT = (SELECT COUNT(USER_ID)
                        FROM USER_INFO
                       WHERE YEAR(JOINED) = '2021');
                   
    -- SELECT @TOTLA_CNT;
    -- 임시테이블 생성 (21년에 가입한 회원ID)
    WITH USER_21 AS
    (
        SELECT USER_ID
          FROM USER_INFO
         WHERE YEAR(JOINED) = '2021'
    ) -- SELECT * FROM USER_21;
    
    -- 조회
    SELECT YEAR(OS.SALES_DATE)          YEAR
         , MONTH(OS.SALES_DATE)         MONTH
         , COUNT(DISTINCT OS.USER_ID)   PUCHASED_USERS
         , ROUND((COUNT(DISTINCT OS.USER_ID) / @TOTLA_CNT), 1)  PUCHASED_RATIO
      FROM ONLINE_SALE      OS
INNER JOIN USER_21          U
        ON OS.USER_ID       = U.USER_ID
  GROUP BY YEAR(OS.SALES_DATE)
         , MONTH(OS.SALES_DATE)
  ORDER BY YEAR(OS.SALES_DATE)
         , MONTH(OS.SALES_DATE)