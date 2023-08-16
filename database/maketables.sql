DROP TABLE IF EXISTS `article`;

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `author_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `introduction` text,
  `link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
);

DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `title_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `readtime` time DEFAULT NULL,
  `text` text,
  `tag` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`title_id`)
);

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `author_id` int DEFAULT NULL,
  `title_id` int DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `author_id` (`author_id`),
  KEY `title_id` (`title_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`title_id`) REFERENCES `title` (`title_id`)
);

