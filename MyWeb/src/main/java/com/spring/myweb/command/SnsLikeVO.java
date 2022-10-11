/*
CREATE TABLE snslike(
    bno NUMBER(10,0) NOT NULL,
    userId VARCHAR2(50) NOT NULL,
    lno NUMBER PRIMARY KEY
);

-- ON DELETE CASCADE:
-- 외래키(FK)를 참조할 때 참조하는 데이터가 삭제되는 경우
-- 참조하고 있는 데이터도 함께 삭제를 진행하겠다.
ALTER TABLE snslike ADD FOREIGN KEY(bno)
REFERENCES snsboard(bno)
ON DELETE CASCADE;

ALTER TABLE snslike ADD FOREIGN KEY(userId)
REFERENCES users(userid)
ON DELETE CASCADE;

CREATE SEQUENCE snslike_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 10000
    NOCYCLE
    NOCACHE;
*/

package com.spring.myweb.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SnsLikeVO {

	private int bno;
	private String userId;
	private int lno;
	
}
