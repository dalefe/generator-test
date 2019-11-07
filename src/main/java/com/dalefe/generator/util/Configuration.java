package com.dalefe.generator.util;

import lombok.Data;

import java.io.Serializable;


/**
 * @author dalefe
 * @version  2019/11/07
 */
@Data
public class Configuration implements Serializable {
    private String author;
    private String packageName;
    private Path path;
    private Db db;

	@Data
    public static class Db {
		private String driver;
        private String url;
        private String username;
        private String password;

        public Db() {
        }

        public Db(String url, String username, String password,String driver) {
            this.url = url;
            this.username = username;
            this.password = password;
            this.driver = driver;
        }

//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
    }
	@Data
    public static class Path {
        private String controller;
        private String service;
        private String interf;
        private String dao;
        private String entity;
        private String mapper;

        public Path() {
        }

        public Path(String controller, String service, String interf,String dao, String entity, String mapper) {
            this.controller = controller;
            this.service = service;
            this.interf = interf;
            this.dao = dao;
            this.entity = entity;
            this.mapper = mapper;
        }
    }

}
