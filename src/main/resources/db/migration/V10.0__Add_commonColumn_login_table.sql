ALTER TABLE LOGIN ADD COLUMN created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                     ADD COLUMN created_by varchar(255) NOT NULL,
                     ADD COLUMN updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                     ADD COLUMN updated_by varchar(255) NOT NULL,
                     ADD COLUMN delete_flg TINYINT(1) NOT NULL DEFAULT 0;