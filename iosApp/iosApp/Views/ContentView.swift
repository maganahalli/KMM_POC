import SwiftUI


struct ContentView: View {
    let categoriesList = ["Movies", " News","Geico Mobile Web Service Test Zig!!!!!!"]
   
	var body: some View {
   
        NavigationView {
                      List {
                          ForEach(categoriesList, id: \.self) { item in
                              NavigationLink.init(
                                                destination: CategoryRouterView(category: item),
                                               label: {
                                                   HStack {
                                                       Text(String(item)).bold()
                                                  Spacer()
                                                   }
                                                       
                                              })
                          }
                      }
                          .listStyle(GroupedListStyle())
                          .navigationTitle("Search by Category")
                         
        }
        
	}
}


struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
    }
}
