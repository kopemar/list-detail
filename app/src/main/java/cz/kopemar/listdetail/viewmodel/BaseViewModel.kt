package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.ViewModel
import cz.kopemar.listdetail.repository.GithubRepository

abstract class BaseViewModel(val githubRepo: GithubRepository) : ViewModel()