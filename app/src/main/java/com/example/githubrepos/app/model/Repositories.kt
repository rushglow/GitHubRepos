package com.example.githubrepos.app.model

data class Repositories(var name: String? = null,
                        var stargazers_count: Int? = null,
                        var forks_count: Int? = null,
                        var language: String? = null,
                        var description: String? = null,
                        var updated_at: String? = null, )
