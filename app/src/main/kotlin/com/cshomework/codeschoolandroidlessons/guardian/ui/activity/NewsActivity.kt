package com.cshomework.codeschoolandroidlessons.guardian.ui.activity

//import com.example.codeschoolandroidlessons.guardian.data.repository.NewsRepositoryImpl

//class NewsActivity : BaseCommonActivity() {
//
//    private lateinit var binding: ActivityGuardianNewsBinding
//    lateinit var viewModel: NewsViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityGuardianNewsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        val newsRepository = NewsRepositoryImpl()
//        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
//        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
//        replaceFragment(ContentNewsFragment.newInstance(), R.id.containerGuardian)
//        checkNetworkConnection(binding.guardianNoInternetConnectionTextView)
//    }
//}