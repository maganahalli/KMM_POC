//
//  DisplayMoviesView.swift
//  iosApp
//
//  Created by Venkatesh Maganahalli on 8/29/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
struct DisplayMoviesView: View {
    
  @ ObservedObject  var networkManager = NetworkManager()
    
    var body: some View {
        ScrollView(.vertical, showsIndicators: false) {
            VStack {
                ForEach(networkManager.movieList, id: \.title) { movie in
                    DisplayMovieRow(movie: movie)
                }
            }
        }
        .padding()
        
        .onAppear(){
            self.networkManager.fetchPopularMovies()
        }
    }
    
}

struct DisplayMoviesView_Previews: PreviewProvider {
    static var previews: some View {
        DisplayMoviesView()
    }
}

