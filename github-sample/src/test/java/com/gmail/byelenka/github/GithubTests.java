package com.gmail.byelenka.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("62743231e636fef8b97ac2863d4add1ed74b3824");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("Byelenka", "java_lessons")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
