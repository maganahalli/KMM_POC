//
//  DataModel.swift
//  iosApp
//
//  Created by Venkatesh Maganahalli on 8/28/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

struct MoviesResult: Decodable{
    let page : Int
    let total_pages : Int
    let total_results : Int
    var results: [Movie]
    let title: String?
}


struct Movie: Decodable {
    let id: CLong
    let title: String
    let overview: String
    var poster_path : String? = nil
    var backdrop_path : String? = nil
 
}

class PopularMovieList {
    
    var  items :[Movie] = []
    
    
    func addMovie(movie: Movie ){
        items.append(movie)
    }
}

