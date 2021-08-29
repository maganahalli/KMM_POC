//
//  DisplayMovieRow.swift
//  iosApp
//
//  Created by Venkatesh Maganahalli on 8/29/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct DisplayMovieRow: View {
    @ ObservedObject  var networkManager = NetworkManager()
    let movie: Movie
    
    var body: some View {
        
        HStack {
            //Text(" Image needs to be loaded")
            if let sharedImage = networkManager.image {
                Image(uiImage: sharedImage)
                    .resizable()
                    .frame(width: 100, height: 150)
                    .cornerRadius(20)
            } else{
                Text("No image")
            }
           
            VStack {
                HStack {
                    Text(movie.title)
                        .frame(alignment: Alignment.topLeading)
                        .foregroundColor(.black)
                        .font(.subheadline)
                    
                    Spacer()
                }
                
                Text(movie.overview)
                    .foregroundColor(.gray)
                    .lineLimit(3)
                
                Spacer()
            }
            .padding()
            Spacer()
            
        }
        
        .onAppear(){
            let baseUrl = "https://image.tmdb.org/t/p/w500/"
            var imagePath = baseUrl + movie.poster_path! ?? ""
            networkManager.fetchImage(imageUrl: imagePath)
        }
    }
}



struct DisplayMovieRow_Previews: PreviewProvider {
    static var previews: some View {
        DisplayMovieRow( movie: Movie(id: 1234, title: "No Title", overview: "OverView", poster_path: nil, backdrop_path: nil))
    }
}
