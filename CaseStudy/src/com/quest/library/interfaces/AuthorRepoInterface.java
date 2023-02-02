package com.quest.library.interfaces;

import com.quest.library.models.Author;

public interface  AuthorRepoInterface 
{
	public abstract Author findauthorbyId(int id);
}
