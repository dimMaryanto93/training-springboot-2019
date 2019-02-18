/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimasm93
 * Created: Feb 18, 2019
 */

create table master_agama
(
  id               int          not null primary key auto_increment,
  name             varchar(64)  not null,
  description      text,
  create_date      timestamp    not null default now(),
  create_by        varchar(100) not null,
  last_update_date datetime,
  last_update_by   varchar(100)
) engine = InnoDB;
