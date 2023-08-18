drop table "Community_Comment";
drop table "Community";
drop table "Category";
drop table "Field";
drop table "Skill";
drop table "Position_Genre";
drop table "Position";
drop table "Type";
drop table  "Skill_Recruit";
drop table  "Recruit_Position_Apply";
drop table  "Recruit_Position_Count";
drop table  "Keep";
drop table  "Comment_Introduction";
drop table  "Introduction";
drop table  "Recruit";

CREATE TABLE "Recruit" (
                           "recruit_seq"	int	NOT NULL,
                           "name"	varchar(45)	NOT NULL,
                           "state"	varchar(45)	NOT NULL,
                           "leader"	int	NOT NULL,
                           "start_date"	date	NULL,
                           "end_date"	date	NULL,
                           "create_at"	date	NOT NULL,
                           "content"	CLOB	NOT NULL,
                           "info"	varchar(1000)	NOT NULL,
                           "field_seq"	int	NOT NULL,
                           "type_seq"	int	NOT NULL
);

CREATE TABLE `Community` (
                             `post_seq`	int	NOT NULL,
                             `created_at`	datetime	NOT NULL,
                             `member_seq`	int	NOT NULL,
                             `view_count`	int	NOT NULL,
                             `like_count`	int	NOT NULL,
                             `content`	CLOB	NOT NULL,
                             `category_seq`	int	NOT NULL
);

CREATE TABLE `Community_Comment` (
                                     `comment_seq`	int	NOT NULL,
                                     `create_at`	datetime	NOT NULL,
                                     `member_seq`	int	NOT NULL,
                                     `content`	CLOB	NOT NULL,
                                     `comment_seq2`	int	NULL,
                                     `post_seq`	int	NOT NULL
);

CREATE TABLE `Position` (
                            `position_seq`	int	NOT NULL,
                            `position_name`	varchar(20)	NOT NULL,
                            `position_genre_seq`	int	NOT NULL
);

CREATE TABLE `Type` (
                        `type_seq`	int	NOT NULL,
                        `name`	varchar(100)	NOT NULL
);

CREATE TABLE `Field` (
                         `field_seq`	int	NOT NULL,
                         `name`	varchar(45)	NOT NULL
);

CREATE TABLE `Introduction` (
                                `recruit_seq`	int	NOT NULL,
                                `like_count`	int	NOT NULL,
                                `created_at`	date	NOT NULL,
                                `content`	CLOB	NOT NULL
);

CREATE TABLE `Recruit_Position_Apply` (
                                          `member_seq`	int	NOT NULL,
                                          `recruit_seq`	int	NOT NULL,
                                          `position_seq`	int	NOT NULL,
                                          `is_accept`	varchar(50)	NOT NULL
);

CREATE TABLE `Keep` (
                        `recruit_seq`	int	NOT NULL,
                        `member_seq`	int	NOT NULL
);

CREATE TABLE `Comment_Introduction` (
                                        `comment_seq`	int	NOT NULL,
                                        `create_at`	date	NOT NULL,
                                        `member_seq`	int	NOT NULL,
                                        `content`	CLOB	NOT NULL,
                                        `comment_seq2`	int	NOT NULL,
                                        `recruit_seq`	int	NOT NULL
);

CREATE TABLE `Category` (
                            `category_seq`	int	NOT NULL,
                            `name`	varchar(100)	NOT NULL
);

CREATE TABLE `Skill` (
                         `skill_seq`	int	NOT NULL,
                         `name`	varchar(100)	NOT NULL
);

CREATE TABLE `Skill_Recruit` (
                                 `recruit_seq`	int	NOT NULL,
                                 `skill_seq`	int	NOT NULL
);

CREATE TABLE `Recruit_Position_Count` (
                                          `recruit_seq`	int	NOT NULL,
                                          `position_seq`	int	NOT NULL,
                                          `count`	int	NOT NULL
);

CREATE TABLE `Position_Genre` (
                                  `position_genre_seq`	int	NOT NULL,
                                  `name`	varchar(20)	NOT NULL
);

ALTER TABLE `Recruit` ADD CONSTRAINT `PK_RECRUIT` PRIMARY KEY (
                                                               `recruit_seq`
    );

ALTER TABLE `Community` ADD CONSTRAINT `PK_COMMUNITY` PRIMARY KEY (
                                                                   `post_seq`
    );

ALTER TABLE `Community_Comment` ADD CONSTRAINT `PK_COMMUNITY_COMMENT` PRIMARY KEY (
                                                                                   `comment_seq`
    );

ALTER TABLE `Position` ADD CONSTRAINT `PK_POSITION` PRIMARY KEY (
                                                                 `position_seq`
    );

ALTER TABLE `Type` ADD CONSTRAINT `PK_TYPE` PRIMARY KEY (
                                                         `type_seq`
    );

ALTER TABLE `Field` ADD CONSTRAINT `PK_FIELD` PRIMARY KEY (
                                                           `field_seq`
    );

ALTER TABLE `Introduction` ADD CONSTRAINT `PK_INTRODUCTION` PRIMARY KEY (
                                                                         `recruit_seq`
    );

ALTER TABLE `Recruit_Position_Apply` ADD CONSTRAINT `PK_RECRUIT_POSITION_APPLY` PRIMARY KEY (
                                                                                             `member_seq`,
                                                                                             `recruit_seq`,
                                                                                             `position_seq`
    );

ALTER TABLE `Keep` ADD CONSTRAINT `PK_KEEP` PRIMARY KEY (
                                                         `recruit_seq`
    );

ALTER TABLE `Comment_Introduction` ADD CONSTRAINT `PK_COMMENT_INTRODUCTION` PRIMARY KEY (
                                                                                         `comment_seq`
    );

ALTER TABLE `Category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
                                                                 `category_seq`
    );

ALTER TABLE `Skill` ADD CONSTRAINT `PK_SKILL` PRIMARY KEY (
                                                           `skill_seq`
    );

ALTER TABLE `Skill_Recruit` ADD CONSTRAINT `PK_SKILL_RECRUIT` PRIMARY KEY (
                                                                           `recruit_seq`,
                                                                           `skill_seq`
    );

ALTER TABLE `Recruit_Position_Count` ADD CONSTRAINT `PK_RECRUIT_POSITION_COUNT` PRIMARY KEY (
                                                                                             `recruit_seq`,
                                                                                             `position_seq`
    );

ALTER TABLE `Position_Genre` ADD CONSTRAINT `PK_POSITION_GENRE` PRIMARY KEY (
                                                                             `position_genre_seq`
    );

ALTER TABLE `Introduction` ADD CONSTRAINT `FK_Recruit_TO_Introduction_1` FOREIGN KEY (
                                                                                      `recruit_seq`
    )
    REFERENCES `Recruit` (
                          `recruit_seq`
        );

ALTER TABLE `Recruit_Position_Apply` ADD CONSTRAINT `FK_Recruit_TO_Recruit_Position_Apply_1` FOREIGN KEY (
                                                                                                          `recruit_seq`
    )
    REFERENCES `Recruit` (
                          `recruit_seq`
        );

ALTER TABLE `Recruit_Position_Apply` ADD CONSTRAINT `FK_Position_TO_Recruit_Position_Apply_1` FOREIGN KEY (
                                                                                                           `position_seq`
    )
    REFERENCES `Position` (
                           `position_seq`
        );

ALTER TABLE `Keep` ADD CONSTRAINT `FK_Recruit_TO_Keep_1` FOREIGN KEY (
                                                                      `recruit_seq`
    )
    REFERENCES `Recruit` (
                          `recruit_seq`
        );

ALTER TABLE `Skill_Recruit` ADD CONSTRAINT `FK_Recruit_TO_Skill_Recruit_1` FOREIGN KEY (
                                                                                        `recruit_seq`
    )
    REFERENCES `Recruit` (
                          `recruit_seq`
        );

ALTER TABLE `Skill_Recruit` ADD CONSTRAINT `FK_Skill_TO_Skill_Recruit_1` FOREIGN KEY (
                                                                                      `skill_seq`
    )
    REFERENCES `Skill` (
                        `skill_seq`
        );

ALTER TABLE `Recruit_Position_Count` ADD CONSTRAINT `FK_Recruit_TO_Recruit_Position_Count_1` FOREIGN KEY (
                                                                                                          `recruit_seq`
    )
    REFERENCES `Recruit` (
                          `recruit_seq`
        );

ALTER TABLE `Recruit_Position_Count` ADD CONSTRAINT `FK_Position_TO_Recruit_Position_Count_1` FOREIGN KEY (
                                                                                                           `position_seq`
    )
    REFERENCES `Position` (
                           `position_seq`
        );

