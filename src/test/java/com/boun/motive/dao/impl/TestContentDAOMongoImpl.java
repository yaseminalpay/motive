package com.boun.motive.dao.impl;

import com.boun.motive.dao.IContentDAO;
import com.boun.motive.model.Content;
import com.boun.motive.repository.ContentMongoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class TestContentDAOMongoImpl {

    @InjectMocks
    private IContentDAO sut = new ContentDAOMongoImpl();

    @Mock
    private Content mockContent;

    @Mock
    private ContentMongoRepository mockRepo;

    private List<String> testTags = new ArrayList<>();



    public TestContentDAOMongoImpl() {
    }

    @Before
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
        testTags.add("Tag1");
        testTags.add("Tag2");
        Mockito.when(mockRepo.findOne(Mockito.anyString())).thenReturn(mockContent);
        Mockito.when(mockContent.getTags()).thenReturn(testTags);
    }


    @Test
    public void initialState_saveContent_repoCallsSave() {
        sut.createContent(mockContent);
        Mockito.verify(mockRepo, Mockito.times(1)).save(mockContent);
    }

    @Test
    public void initialState_getContentById_repoCallsFindOne() {
        sut.getContentById(Mockito.anyString());
        Mockito.verify(mockRepo, Mockito.times(1)).findOne(Mockito.anyString());
    }


    @Test
    public void tagListHasElements_GivenIdOfContentWithAlreadyExistingTag_TagNotAdded() {
        sut.tagContent("12123", "Tag1");
        Assert.assertEquals(2, testTags.size());
        Mockito.verify(mockRepo, Mockito.times(0)).save(mockContent);

    }

    @Test
    public void tagListHasElements_GivenIdOfContentWithNonExistingTag_NewTagAdded() {
        sut.tagContent("123123", "NewTag");
        Assert.assertEquals(3, testTags.size());
        Mockito.verify(mockRepo, Mockito.times(1)).save(mockContent);

    }
 }
