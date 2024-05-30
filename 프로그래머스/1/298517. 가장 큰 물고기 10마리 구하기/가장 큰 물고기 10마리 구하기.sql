-- 코드를 작성해주세요
    SELECT ID
         , LENGTH
      FROM FISH_INFO
  GROUP BY ID
         , LENGTH
    HAVING LENGTH > 10
  ORDER BY LENGTH DESC
         , ID
     LIMIT 10;
