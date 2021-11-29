/* 음원 관리하는 사이트를 구축하려 한다. 이 때 필요한 ERD를 설계하세요.
- 멜론, 지니 등을 참고
- 각자 제한 조건을 기술하고, 해당 제한 조건에 맞는 ERD를 설계
- 음원
  - 노래 하나하나
- 앨범
  - 여러 음원이 하나로 묶여 있는 테이블
- 아티스트
  - 가수 개인
- 그룹
  - 앨범을 발매할 때 포함되는 아티스트로, 솔로도 그룹으로 포함

*/
DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
	`al_num`	varchar(20)	NOT NULL,
	`al_title`	varchar(100)	NULL,
	`al_date`	datetime	NULL,
	`al_genre`	varchar(20)	NULL,
	`al_publisher`	varchar(100)	NULL,
	`al_produce_company`	varchar(100)	NULL,
	`al_notice`	longtext	NULL,
	`al_ar_num`	varchar(20)	NOT NULL,
	`gr_num`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
	`so_num`	varchar(20)	NOT NULL,
	`so_title`	varchar(100)	NULL,
	`so_singer`	varchar(100)	NULL,
	`so_date`	datetime	NULL,
	`so_like`	int	NULL,
	`so_al_num`	varchar(20)	NULL,
	`so_si_num`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `playlist`;

CREATE TABLE `playlist` (
	`li_num`	varchar(20)	NOT NULL,
	`li_title`	varchar(100)	NULL,
	`li_date`	datetime	NULL,
	`li_me_num`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_num`	varchar(20)	NOT NULL,
	`me_name`	varchar(100)	NULL,
	`me_id`	varchar(50)	NULL,
	`me_pw`	longtext	NULL,
	`me_join`	datetime	NULL,
	`me_reg_num`	varchar(14)	NULL,
	`me_nick`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `artist`;

CREATE TABLE `artist` (
	`ar_num`	varchar(20)	NOT NULL,
	`ar_name`	varchar(100)	NULL,
	`ar_debut`	datetime	NULL,
	`ar_birth`	datetime	NULL,
	`si_prize`	longtext	NULL
);

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
	`gr_num`	varchar(20)	NOT NULL,
	`gr_name`	varchar(100)	NULL,
	`gr_debut`	datetime	NULL
);

DROP TABLE IF EXISTS `singer`;

CREATE TABLE `singer` (
	`si_num`	varchar(20)	NOT NULL,
	`si_gr_num`	varchar(20)	NULL,
	`si_ar_num`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `playnowlist`;

CREATE TABLE `playnowlist` (
	`pn_num`	varchar(20)	NOT NULL,
	`pn_li_num`	varchar(20)	NOT NULL,
	`pn_so_num`	varchar(20)	NOT NULL,
	`pn_me_num`	varchar(20)	NOT NULL
);

ALTER TABLE `album` ADD CONSTRAINT `PK_ALBUM` PRIMARY KEY (
	`al_num`
);

ALTER TABLE `song` ADD CONSTRAINT `PK_SONG` PRIMARY KEY (
	`so_num`
);

ALTER TABLE `playlist` ADD CONSTRAINT `PK_PLAYLIST` PRIMARY KEY (
	`li_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_num`
);

ALTER TABLE `artist` ADD CONSTRAINT `PK_ARTIST` PRIMARY KEY (
	`ar_num`
);

ALTER TABLE `group` ADD CONSTRAINT `PK_GROUP` PRIMARY KEY (
	`gr_num`
);

ALTER TABLE `singer` ADD CONSTRAINT `PK_SINGER` PRIMARY KEY (
	`si_num`
);

ALTER TABLE `playnowlist` ADD CONSTRAINT `PK_PLAYNOWLIST` PRIMARY KEY (
	`pn_num`
);

ALTER TABLE `album` ADD CONSTRAINT `FK_artist_TO_album_1` FOREIGN KEY (
	`al_ar_num`
)
REFERENCES `artist` (
	`ar_num`
);

ALTER TABLE `album` ADD CONSTRAINT `FK_group_TO_album_1` FOREIGN KEY (
	`gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `song` ADD CONSTRAINT `FK_album_TO_song_1` FOREIGN KEY (
	`so_al_num`
)
REFERENCES `album` (
	`al_num`
);

ALTER TABLE `song` ADD CONSTRAINT `FK_singer_TO_song_1` FOREIGN KEY (
	`so_si_num`
)
REFERENCES `singer` (
	`si_num`
);

ALTER TABLE `playlist` ADD CONSTRAINT `FK_member_TO_playlist_1` FOREIGN KEY (
	`li_me_num`
)
REFERENCES `member` (
	`me_num`
);

ALTER TABLE `singer` ADD CONSTRAINT `FK_group_TO_singer_1` FOREIGN KEY (
	`si_gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `singer` ADD CONSTRAINT `FK_artist_TO_singer_1` FOREIGN KEY (
	`si_ar_num`
)
REFERENCES `artist` (
	`ar_num`
);

ALTER TABLE `playnowlist` ADD CONSTRAINT `FK_playlist_TO_playnowlist_1` FOREIGN KEY (
	`pn_li_num`
)
REFERENCES `playlist` (
	`li_num`
);

ALTER TABLE `playnowlist` ADD CONSTRAINT `FK_song_TO_playnowlist_1` FOREIGN KEY (
	`pn_so_num`
)
REFERENCES `song` (
	`so_num`
);

ALTER TABLE `playnowlist` ADD CONSTRAINT `FK_member_TO_playnowlist_1` FOREIGN KEY (
	`pn_me_num`
)
REFERENCES `member` (
	`me_num`
);

