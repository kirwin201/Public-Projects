BEGIN TRANSACTION;

-- Initialization script for SFL Database


DROP TABLE IF EXISTS member_team, member_record, final_standing CASCADE;

CREATE TABLE member_team
(
	member_id serial,
	member_name varchar(64) NOT NULL,
	team_name varchar(64) NOT NULL,
	is_current boolean DEFAULT true,
	
	CONSTRAINT PK_member PRIMARY KEY (member_id)
);

CREATE TABLE member_record
(
	member_id int,
	seasons int,
	wins int,
	loss int,
	draw int,
	
	CONSTRAINT FK_member FOREIGN KEY (member_id) REFERENCES member_team (member_id)
);

CREATE TABLE final_standing
(
	season int,
	first_place int,
	second_place int,
	third_place int,
	fourth_place int,
	
	CONSTRAINT PK_season PRIMARY KEY (season),
	CONSTRAINT FK_frist_place FOREIGN KEY (first_place) REFERENCES member_team (member_id),
	CONSTRAINT FK_second_place FOREIGN KEY (second_place) REFERENCES member_team (member_id),
	CONSTRAINT FK_third_place FOREIGN KEY (third_place) REFERENCES member_team (member_id),
	CONSTRAINT FK_fourth_place FOREIGN KEY (fourth_place) REFERENCES member_team (member_id)
);



-- Populated with Win/Loss Records following the 2021-2022 season

INSERT INTO member_team (member_name, team_name) VALUES ('Jack', 'Do Your Job');
INSERT INTO member_team (member_name, team_name) VALUES ('Jimmy', 'The Elite');
INSERT INTO member_team (member_name, team_name) VALUES ('Ben H', 'Team Manchester Maniac');
INSERT INTO member_team (member_name, team_name) VALUES ('Mike', 'The Poisonous Nuts');
INSERT INTO member_team (member_name, team_name) VALUES ('Kyle', 'The Irdogs');
INSERT INTO member_team (member_name, team_name) VALUES ('Sam', 'Slammin Guarantee');
INSERT INTO member_team (member_name, team_name) VALUES ('Tom', 'Belichick Yo Self');
INSERT INTO member_team (member_name, team_name) VALUES ('Patrick', 'No, this is Patrick');
INSERT INTO member_team (member_name, team_name) VALUES ('Jon/Bill', 'Electric Dream Machine');
INSERT INTO member_team (member_name, team_name) VALUES ('Johnny', 'Team Turbo Win');
INSERT INTO member_team (member_name, team_name) VALUES ('Jeremy', 'Too Tired To Think');
INSERT INTO member_team (member_name, team_name) VALUES ('Ben W', 'The Slowskies');
INSERT INTO member_team (member_name, team_name, is_current) VALUES ('Fahad', 'Todds Plan', false);

INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (1, 7, 64, 28, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (2, 6, 43, 36, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (3, 7, 41, 51, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (4, 7, 49, 43, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (5, 7, 47, 44, 1);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (6, 7, 48, 44, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (7, 7, 40, 52, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (8, 7, 41, 51, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (9, 7, 41, 50, 1);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (10, 7, 46, 46, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (11, 7, 38, 54, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (12, 3, 20, 20, 0);
INSERT INTO member_record (member_id, seasons, wins, loss, draw) VALUES (13, 4, 29, 23, 0);

INSERT INTO final_standing (season, first_place, second_place, third_place, fourth_place) VALUES (2015, 1, 11, 4, 8);
INSERT INTO final_standing (season, first_place, second_place, third_place, fourth_place) VALUES (2016, 3, 8, 1, 4);
INSERT INTO final_standing (season, first_place, second_place, third_place, fourth_place) VALUES (2017, 4, 5, 6, 13);
INSERT INTO final_standing (season, first_place, second_place, third_place, fourth_place) VALUES (2018, 1, 6, 5, 11);
INSERT INTO final_standing (season, first_place, second_place, third_place, fourth_place) VALUES (2019, 2, 1, 9, 4);
INSERT INTO final_standing (season, first_place, second_place, third_place, fourth_place) VALUES (2020, 1, 7, 3, 5);
INSERT INTO final_standing (season, first_place, second_place, third_place, fourth_place) VALUES (2021, 10, 12, 3, 2);


-- SELECT statements used to check tables

SELECT * FROM member_team;
SELECT * FROM member_record;
SELECT * FROM final_standing;

SELECT mt.member_id, mt.member_name, mt.team_name, mr.seasons, mr.wins, mr.loss, mr.draw FROM member_team AS mt
	INNER JOIN member_record AS mr ON mt.member_id = mr.member_id;

SELECT ss.season, mt1.member_name AS first_place, mt2.member_name AS second_place, mt3.member_name AS thrid_place, mt4.member_name AS fourth_place FROM final_standing AS ss
	INNER JOIN member_team AS mt1 ON ss.first_place = mt1.member_id
		INNER JOIN member_team AS mt2 ON ss.second_place = mt2.member_id
			INNER JOIN member_team AS mt3 ON ss.third_place = mt3.member_id
				INNER JOIN member_team AS mt4 ON ss.fourth_place = mt4.member_id;


--ROLLBACK TRANSACTION;
COMMIT TRANSACTION;