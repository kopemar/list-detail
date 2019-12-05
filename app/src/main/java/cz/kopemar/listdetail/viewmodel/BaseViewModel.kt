package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.ViewModel
import cz.kopemar.listdetail.repository.GithubRepository

/**
 * Abstract ViewModel, superclass for other view models.
 */
abstract class BaseViewModel(val githubRepo: GithubRepository) : ViewModel()