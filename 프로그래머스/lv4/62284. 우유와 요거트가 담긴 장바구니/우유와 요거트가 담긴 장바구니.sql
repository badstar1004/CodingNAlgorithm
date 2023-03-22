-- 코드를 입력하세요

    -- CROSS JOIN 사용 (ft.DISTINCT)
    SELECT DISTINCT
           CP1.CART_ID
      FROM CART_PRODUCTS    CP1
CROSS JOIN CART_PRODUCTS    CP2
        ON CP1.CART_ID       = CP2.CART_ID 
       AND CP1.NAME          = 'Milk'
       AND CP2.NAME          = 'Yogurt'