//
//  NetworkManager.swift
//  iosApp
//
//  Created by Venkatesh Maganahalli on 8/29/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

class NetworkManager: ObservableObject {
    
    let movieService = WebServiceCallWithGet()
    
    var popularMovies = [ Movie ]()
    
   @Published var movieList = [Movie]()
    @Published var image : UIImage?
    
    
    
    func fetchPopularMovies(){
        
        movieService.getMovieList { listOfMovies in
            listOfMovies.forEach { sharedMovie in
                let newMovie = Movie(id: CLong(sharedMovie.id), title: sharedMovie.title, overview: sharedMovie.overview, poster_path: sharedMovie.poster_path, backdrop_path: sharedMovie.backdrop_path!)
                self.popularMovies.append(newMovie)
               
            }
        
            self.movieList = self.popularMovies
        } failure: { error in
            print(" Error in loading Movies")
        }
    }
    
    
    func fetchImage(imageUrl : String){
        
        movieService.getImage(url: imageUrl) { sharedImage in
            self.image = sharedImage
        } failure: { error in
            print(" Error in loading image")
        }

        
        
    }
    
}
